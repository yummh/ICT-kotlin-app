package screen

import LINE_DIVIDER
import data.CartItems
import extension.getNotEmptyString

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
        showPreviousScreenOption()
    }

    private fun showPreviousScreenOption(){   // 이전 화면으로 이동하기
        println(
            """
            $LINE_DIVIDER
            이전 화면으로 돌아가시겠습니까? (Y/N)
        """.trimIndent()
        )
        when (readLine().getNotEmptyString()){
            "y" -> {
                moveToPreviouwScreen()
            }
            "n" -> {
                showCartItems()
            }
            else -> {
                // TODO 재입력 요청청
            }
        }
    }

    private fun moveToPreviouwScreen() {
        ScreenStack.pop()

        when (val previousScreen = ScreenStack.peek()){
            is AppCategory -> {
                previousScreen.showCategories()
            }
            is AppProductList -> {
                previousScreen.showProducts()
            }
            is MainScreen, is AppHome -> {
                // 아무것도 하지 않음
            }
        }
    }
}