package com.example.pagingheadersample


interface Repository {
    fun getHeader(id: Int, shop: String): Header
    fun getBody(id: Int, maker: String, commodity: String): Body
    fun getMain(): List<ViewType>
}

class RepositoryImpl : Repository {

    private val list = listOf(
        ViewType.HeaderViewType(0, "コンビニA"),
        ViewType.BodyViewType(1, "A社", "ガム"),
        ViewType.BodyViewType(2, "B社", "チョコレート"),
        ViewType.BodyViewType(3, "C社", "クッキー"),
        ViewType.HeaderViewType(4, "コンビニB"),
        ViewType.BodyViewType(5, "D社", "おにぎり"),
        ViewType.BodyViewType(6, "E社", "アイスコーヒー"),
        ViewType.HeaderViewType(7, "コンビニC"),
        ViewType.BodyViewType(8, "F社", "ミネラルウォーター"),
        ViewType.BodyViewType(9, "G社", "飴"),
        ViewType.BodyViewType(10, "H社", "オレンジジュース"),
        ViewType.HeaderViewType(11, "コンビニD"),
        ViewType.BodyViewType(12, "I社", "鮭おにぎり"),
        ViewType.BodyViewType(13, "J社", "カフェオレ"),
        ViewType.HeaderViewType(14, "スーパーE"),
        ViewType.BodyViewType(15, "K社", "ポケットティッシュ"),
        ViewType.BodyViewType(16, "L社", "ビスケット"),
        ViewType.BodyViewType(17, "M社", "ポテトチップス"),
        ViewType.HeaderViewType(18, "スーパーF"),
        ViewType.BodyViewType(19, "N社", "梅おにぎり"),
        ViewType.BodyViewType(20, "O社", "栄養ドリンク"),
        ViewType.HeaderViewType(21, "スーパーG"),
        ViewType.BodyViewType(22, "P社", "ブレスケア"),
        ViewType.BodyViewType(23, "Q社", "煎餅"),
        ViewType.BodyViewType(24, "R社", "アイスクリーム"),
        ViewType.HeaderViewType(25, "スーパーH"),
        ViewType.BodyViewType(26, "S社", "昆布おにぎり"),
        ViewType.BodyViewType(27, "T社", "ビール")

    )

    override fun getHeader(id: Int, shop: String): Header {
        return Header(id, shop)
    }

    override fun getBody(id: Int, maker: String, commodity: String): Body {
        return Body(id, maker, commodity)
    }

    override fun getMain(): List<ViewType> {
        return list
    }

}