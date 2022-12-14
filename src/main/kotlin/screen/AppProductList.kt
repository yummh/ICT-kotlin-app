package screen

import LINE_DIVIDER
import com.sun.tools.javac.Main
import data.CartItems
import data.Product
import extension.getNotEmptyString

class AppProductList(private val selectedCategory: String) : Screen()  {
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

    fun showProducts() {
        ScreenStack.push(this)
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {   // 선택한 물품이 하나라도 존재하면 안내
            println(
                """
                $LINE_DIVIDER
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent()
            )

            categoryProducts.forEachIndexed { index, product ->
                println("${index}. ${product.name}")
            }
            showCartOption(categoryProducts)
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProduct: List<Product>){
        println(
            """
                $LINE_DIVIDER
                즐겨찾기에 담을 상품 번호를 선택해주세요.
            """.trimIndent()
        )
        val selectedIndex = readLine()?.toIntOrNull()!!
        categoryProduct.getOrNull(selectedIndex)?.let {product ->
            CartItems.addProduct(product)

            println("=> 즐겨찾기로 이동하시려면 #을, 계속 앱을 사용하시려면 *을 입력해주세요.")

            val answer = readLine().getNotEmptyString()
            if (answer == "#"){
                val mainScreen = MainScreen()
                mainScreen.showCartItems()
            } else if (answer == "*"){
                showProducts()
            } else{
                // TODO 그 외 값을 입력한 경우에 대한 처리
            }
        }?:kotlin.run{
           println("$selectedIndex 번은 목록에 없는 상품번호입니다. 다시 입력해주세요.")
           showProducts()
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전입니다.")
    }
}