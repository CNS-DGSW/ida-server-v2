rootProject.name = "ida"

include("api")

include("core")
include("core:data")
include("core:id-gen")
include("core:hash")

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
include("applicant:applicant-web-adapter")

include("notice")
include("notice:notice-domain")
include("notice:notice-application")
include("notice:notice-jpa-adapter")
include("notice:notice-web-adapter")
include("notice:notice-s3-adapter")

include("secondary")
include("secondary:secondary-domain")
include("secondary:secondary-application")
include("secondary:secondary-jpa-adapter")
include("secondary:secondary-web-adapter")

include("auth")
include("auth:auth-web-adapter")
include("auth:auth-application")