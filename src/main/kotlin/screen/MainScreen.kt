package screen

import LINE_DIVIDER
import data.CartItems

class MainScreen : Screen() {
    private val products = CartItems.products

    fun showCartItems(){
        ScreenStack.push(this)
        if (products.isNotEmpty()){
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                        $LINE_DIVIDER
                        즐겨찾기에 담은 카테고리 목록입니다.
                    """.trimIndent()
                ) {product ->
                    "카테고리: ${product.categoryLabel} / 상품명: ${product.name} / 수량: ${products[product]}"
                }
            )
        } else{
            println("""
                즐겨찾기에 담은 카테고리가 없습니다.
            """.trimIndent())
        }
    }
}
