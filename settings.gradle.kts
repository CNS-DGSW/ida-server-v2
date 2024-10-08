rootProject.name = "ida"

include("api")
include("admin-api")

include("core")
include("core:data")
include("core:id-gen")
include("core:file")
include("core:exception-handler")
include("core:authentication")
include("core:excel")

include("member")
include("member:member-id")
include("member:member-domain")
include("member:member-application")
include("member:member-jpa-adapter")
include("member:member-web-adapter")

include("applicant")
include("applicant:applicant-domain")
include("applicant:applicant-application")
include("applicant:applicant-jpa-adapter")
include("applicant:applicant-s3-adapter")
include("applicant:applicant-web-adapter")

include("admission")
include("admission:admission-domain")
include("admission:admission-application")
include("admission:admission-jpa-adapter")
include("admission:admission-web-adapter")

include("secondary")
include("secondary:secondary-domain")
include("secondary:secondary-application")
include("secondary:secondary-jpa-adapter")
include("secondary:secondary-web-adapter")


include("notice")
include("notice:notice-domain")
include("notice:notice-application")
include("notice:notice-jpa-adapter")
include("notice:notice-web-adapter")
include("notice:notice-s3-adapter")

include("auth")
include("auth:auth-web-adapter")
include("auth:auth-application")