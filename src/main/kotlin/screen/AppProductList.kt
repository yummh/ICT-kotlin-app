package screen

import data.Product

class AppProductList {
    private val products = arrayOf(
        Product(categoryLabel = "날씨", name = "날씨 정보"),
        Product(categoryLabel = "사고", name = "인명피해 사고"),
        Product(categoryLabel = "챗봇", name = "챗봇"),
        Product(categoryLabel = "공지사항", name = "공지사항"),
        Product(categoryLabel = "환경설정", name = "환경설정"),
    )
    private val categories: Map<String, List<Product>> = products.groupBy { product ->
        product.categoryLabel
    }

    fun showProducts(selectedCategory: String) {
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {   // 선택한 물품이 하나라도 존재하면 안내
            println(
                """
                ***====================***
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent()
            )

            val productSize = categoryProducts.size
            for (index in 0  until  productSize) {
                println("${index}.${categoryProducts[index].name}")
            }
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전입니다.")
    }
}