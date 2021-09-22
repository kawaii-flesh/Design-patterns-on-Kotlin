class XMLDataProvider
{
    fun getDataAsXML(): String = """
                                 |<data>
                                 |  <value>
                                 |  1
                                 |  </value>
                                 |  <value>
                                 |  2
                                 |  </value>
                                 |</data>""".trimMargin()
}

class JSONDataProvider
{
    fun getDataAsJSON(): String = """
                                 |{
                                 |  "data": [1, 2]
                                 |}""".trimMargin()
}

open class DataProvider
{
    val someProperty: Int = (0..10).random()
    open fun getDataAsArray(): Array<Int> = arrayOf(1, 2)
}


class XMLAdapter(val xmlDataProvider: XMLDataProvider): DataProvider()
{
    override fun getDataAsArray(): Array<Int>
    {
        val source = xmlDataProvider.getDataAsXML()
        // Some converting from XML
        return arrayOf(1, 2)
    }
}

class JSONAdapter(val jsonDataProvider: JSONDataProvider): DataProvider()
{
    override fun getDataAsArray(): Array<Int>
    {
        val source = jsonDataProvider.getDataAsJSON()
        // Some converting from JSON
        return arrayOf(1, 2)
    }
}

class Client
{
    fun dataProcessing(dataProvider: DataProvider)
    {
        val array = dataProvider.getDataAsArray()
        //Some processing
    }
}

fun main()
{
    val jsonDataProvider = JSONDataProvider()
    val jsonAdapter = JSONAdapter(jsonDataProvider)

    val client = Client()
    client.dataProcessing(jsonAdapter)    
}