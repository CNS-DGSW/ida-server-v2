package com.dgswiphak.ida.aggregate.question

import com.dgswiphak.ida.domain.question.dto.request.CreateQuestionRequest
import com.dgswiphak.ida.domain.question.dto.request.UpdateQuestionRequest
import com.dgswiphak.ida.domain.question.dto.response.QuestionResponse
import com.dgswiphak.ida.domain.question.dto.response.QuestionsResponse
import com.dgswiphak.ida.domain.question.usecase.*
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/question")
class QuestionWebAdapter(
    private val createQuestionUseCase: CreateQuestionUseCase,
    private val deleteQuestionUseCase: DeleteQuestionUseCase,
    private val queryQuestionAllUseCase: QueryQuestionAllUseCase,
    private val queryQuestionDetailsUseCase: QueryQuestionDetailsUseCase,
    private val updateQuestionUseCase: UpdateQuestionUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNotice(@RequestBody request: CreateQuestionRequest) {
        createQuestionUseCase.execute(request)
    }

    @DeleteMapping("/{question-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteNotice(@PathVariable("question-id") @NotNull questionId: Long) {
        deleteQuestionUseCase.execute(questionId)
    }

    @PatchMapping("/{question-id}")
    fun updateNotice(
        @PathVariable("question-id") @NotNull questionId:Long,
        @RequestBody request: UpdateQuestionRequest
    ) {
        updateQuestionUseCase.execute(questionId, request)
    }

    @GetMapping("/{question-id}")
    fun queryDetail(@PathVariable("question-id") @NotNull questionId: Long): QuestionResponse {
        return queryQuestionDetailsUseCase.execute(questionId)
    }

    @GetMapping
    fun queryAllNotices(): QuestionsResponse {
        return queryQuestionAllUseCase.execute()
    }
}