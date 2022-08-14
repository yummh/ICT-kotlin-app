fun main(args: Array<String>) {
    println("안녕하세요, ICT APP에 오신 것을 환영합니다!")
    println("앱을 계속 사용하시려면 이름을 입력해주세요 : ")

    val name = readLine()
    println(
        """
            반갑습니다, $name 님 원하시는 카테고리를 입력해주세요.
        """.trimIndent())

    /*
        1. 상품 카테고리 표기
        2. 사용자 입력 받기
        3. 사용자가 기대하는 값을 입력하지 않는 경우에 대한 처리
    */
    val categories = arrayOf("날씨", "복지", "챗봇")
    for (category in categories) {
        println(category)
    }
    println("메인화면으로 이동하려면 #을 입력해주세요")

    var selectedCategory = readLine()
    while (selectedCategory.isNullOrBlank()) {
        println("원하는 카테고리를 입력해주세요")
        selectedCategory = readLine()
    }

    if (selectedCategory == "#") {
        // TODO 1. 메인화면 이동
    } else {
        // TODO 2. 카테고리 목록 보여주기
        // TODO 3. 카테고리 목록에 없는 값을 입력하는 경우
    }
}