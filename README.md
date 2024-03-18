# ida-server-v2


### 커밋 메세지 규칙
커밋 메세지는 아래를 따르도록 합니다.

-   feat : 새로운 기능을 추가하는 경우
-   fix : 버그를 고친경우
-   docs : 문서를 수정한 경우
-   style : 코드 포맷 변경, 세미콜론 누락, 코드 수정이 없는경우
-   refactor : 코드 리펙토링
-   test : 테스트 코드. 리펙토링 테스트 코드를 추가했을 때
-   chore : 빌드 업무 수정, 패키지 매니저 수정
-   rename : 파일명(or 폴더명) 을 수정한 경우
-   remove : 코드(파일) 의 삭제가 있을 때. 

### 이슈 명명 규칙


이슈는 github 프로젝트를 통해 이슈를 생성합니다. 이때, 진행해야하는 업무를 작성합니다. 명명규칙은 다음을 따릅니다. ※ topic은 "무엇"을 중점적으로 할 것인지에 대해 작성하면 됩니다.

-   일반 설정의 경우 - config-(topic)
    -   ex) config-initialize
-   기능 구현의 경우 - feature-(topic)
    -   ex) feature-school-domain
-   리팩토링의 경우 - refactor-(topic)
    -   ex) refactor-score-calculate
-   핫픽스의 경우 - hotfix-(topic)
    -   ex) hotfix-attendance-score
-   요구사항 변동의 경우 - change-(topic)
    -   ex) change-volunteer

### 브랜치 명명 규칙

이슈 생성을 통해 생성된 이슈 넘버를 통해 참조하도록 합니다.

-   config-#(n)
-   feature-#(n)
-   refactor-#(n)
-   hotfix-#(n)
-   change-#(n)
-   merge-#(n)
    -   merge 브랜치는 레이어 검수를 위해 필요한 브랜치입니다.

### 병합 규칙

config, hotfix 브랜치는 merge commit으로 진행합니다. feature, change, refactor, merge 브랜치는 squash & merge로 진행합니다. 단, change의 경우 기록이 남아있어야 하다고 판단된다면 merge commit을 허용합니다.
