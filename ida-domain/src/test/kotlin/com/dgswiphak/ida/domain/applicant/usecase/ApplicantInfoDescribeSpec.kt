import com.dgswiphak.ida.domain.applicant.dto.request.UpdateApplicantInfoRequest
import com.dgswiphak.ida.domain.applicant.fixture.createApplicant
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.type.Gender
import com.dgswiphak.ida.domain.applicant.spi.query.CommandApplicantSpi
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi
import com.dgswiphak.ida.domain.applicant.usecase.ApplicantInfoUseCase
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import java.time.LocalDate

class ApplicantInfoDescribeSpec : DescribeSpec({
    val commandApplicantSpi = mockk<CommandApplicantSpi>(relaxed = true)
    val queryApplicantSpi = mockk<QueryApplicantSpi>()
    val applicantInfoUseCase = ApplicantInfoUseCase(commandApplicantSpi, queryApplicantSpi)

    describe("지원생의 개인정보를 수정합니다.") {
        val applicant = createApplicant()
        val request = UpdateApplicantInfoRequest(
            name = "맞다",
            birth = LocalDate.of(2010, 4, 3),
            phoneNumber = "010123456789",
            gender = Gender.FEMALE
        )

        context("지원생이 존재할 때") {
            beforeTest {
                every { queryApplicantSpi.findById(applicant.id) } returns applicant
            }

            it("지원생의 정보가 수정된다.") {
                applicantInfoUseCase.updateInformation(applicant.id, request)

                applicant.privacy.name shouldBe request.name
                applicant.privacy.birth shouldBe request.birth
                applicant.privacy.phone?.value shouldBe request.phoneNumber
                applicant.privacy.gender?.value shouldBe request.gender.value
            }
        }

        context("지원생이 존재하지 않을 때") {
            beforeTest {
                every { queryApplicantSpi.findById(applicant.id) } returns null
            }

            it("예외를 던집니다.") {
                shouldThrow<RuntimeException> {
                    applicantInfoUseCase.updateInformation(applicant.id, request)
                }
            }
        }
    }

    describe("지원생의 개인정보를 조회합니다.") {
        val applicant = createApplicant()
        context("지원생이 존재할 때") {
            beforeTest {
                every { queryApplicantSpi.findById(applicant.id) } returns applicant
            }

            it("지원생의 정보가 반환됩니다.") {
                val response = applicantInfoUseCase.findInformation(applicant.id)
                response.name shouldBe applicant.privacy.name
                response.birth shouldBe applicant.privacy.birth
                response.phoneNumber shouldBe applicant.privacy.phone?.value
                response.gender shouldBe applicant.privacy.gender?.value
            }
        }

        context("지원생이 존재하지 않을 때") {
                beforeTest {
                    every { queryApplicantSpi.findById(applicant.id) } returns null
                }
            it("예외를 던집니다") {
                shouldThrow<RuntimeException> {
                    applicantInfoUseCase.findInformation(applicant.id)
                }
            }
        }
    }

})