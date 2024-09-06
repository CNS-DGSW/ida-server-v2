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

include("notice")

include("secondary")

