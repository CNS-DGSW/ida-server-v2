rootProject.name = "ida"

include("ida-domain")
include("ida-infrastructure")
include("ida-http-application")

include("core")
include("core:data")

include("member")
include("member:member-domain")
include("member:member-application")
include("member:member-jpa-adapter")
include("member:member-web-adapter")


