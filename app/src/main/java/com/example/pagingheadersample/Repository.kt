package com.example.pagingheadersample


interface Repository {
    fun getHeader(id: Int, shop: String): Header
    fun getBody(id: Int, maker: String, commodity: String): Body
    fun getMain(): List<Item>
}

class RepositoryImpl : Repository {

    private val list = listOf(
        Header(0, "コンビニA"),
        Body(1, "A社", "ガム"),
        Body(2, "B社", "チョコレート"),
        Body(3, "C社", "クッキー"),
        Header(4, "コンビニB"),
        Body(5, "D社", "おにぎり"),
        Body(6, "E社", "アイスコーヒー"),
        Header(7, "コンビニC"),
        Body(8, "F社", "ミネラルウォーター"),
        Body(9, "G社", "飴"),
        Body(10, "H社", "オレンジジュース"),
        Header(11, "コンビニD"),
        Body(12, "I社", "鮭おにぎり"),
        Body(13, "J社", "カフェオレ"),
        Header(14, "スーパーE"),
        Body(15, "K社", "ポケットティッシュ"),
        Body(16, "L社", "ビスケット"),
        Body(17, "M社", "ポテトチップス"),
        Header(18, "スーパーF"),
        Body(19, "N社", "梅おにぎり"),
        Body(20, "O社", "栄養ドリンク"),
        Header(21, "スーパーG"),
        Body(22, "P社", "ブレスケア"),
        Body(23, "Q社", "煎餅"),
        Body(24, "R社", "アイスクリーム"),
        Header(25, "スーパーH"),
        Body(26, "S社", "昆布おにぎり"),
        Body(27, "T社", "ビール")

    )

    override fun getHeader(id: Int, shop: String): Header {
        return Header(id, shop)
    }

    override fun getBody(id: Int, maker: String, commodity: String): Body {
        return Body(id, maker, commodity)
    }

    override fun getMain(): List<Item> {
        return list
    }

}