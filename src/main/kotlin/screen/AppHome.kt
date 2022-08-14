package screen

class AppHome {
    fun start(){
        showWelcomeMessage()
        showCategories()
    }

    private fun showWelcomeMessage() {
        println("안녕하세요, ICT APP에 오신 것을 환영합니다!")
        println("앱을 계속 사용하시려면 이름을 입력해주세요 : ")

        val name = readLine()
        println(
            """
                반갑습니다, $name 님 원하시는 카테고리를 입력해주세요.
            """.trimIndent()
        )
    }

    private fun showCategories(){
        val appCategory = AppCategory()
        appCategory.showCategories()
    }
}