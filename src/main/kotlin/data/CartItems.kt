package data

object CartItems {
    // map 사용 - 상품 수량 정보도 저장하기 위해
    private val mutableProducts = mutableMapOf<Product, Int>()
    val products: Map<Product, Int> = mutableProducts

    fun addProduct(product: Product){
        mutableProducts[product]?.let {
            mutableProducts[product] = it + 1
        } ?: kotlin.run{
            mutableProducts[product] = 1
        }
    }
}