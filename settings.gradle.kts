rootProject.name = "ida"

include("ida-domain")
include("ida-infrastructure")
include("ida-http-application")

include("api")

include("core")
include("core:data")
include("core:id-gen")

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
include("applicant:applicant-jpa-adapter")

include("notice")
include("notice:notice-domain")
include("notice:notice-application")
include("notice:notice-jpa-adapter")
include("notice:notice-web-adapter")

include("secondary")

