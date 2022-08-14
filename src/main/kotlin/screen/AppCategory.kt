package screen

class AppCategory {
    public fun showCategories() {
        val categories = arrayOf("날씨", "사고", "챗봇")
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
            if (categories.contains(selectedCategory)){
                // TODO 2. 카테고리 목록 보여주기
                val appProductList = AppProductList()
                appProductList.showProducts(selectedCategory)
            }else{
                // TODO 3. 카테고리 목록에 없는 값을 입력하는 경우
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리입니다. 다시 입력해주세요.")
        showCategories()
    }
}