interface IDataProvider
{
    fun getData(): Array<Int>
    fun registerOpperation()
}

class StandartDataProvider: IDataProvider
{
    override fun getData(): Array<Int>  = arrayOf(1, 2, 3)
    override fun registerOpperation() = println("Simple registration") 
}

class FileDataProvider(val dataProvider: IDataProvider = StandartDataProvider()): IDataProvider by dataProvider
{
    override fun getData(): Array<Int>
    {
        // Read data from some file resource
        return arrayOf(1, 2, 3)   
    }
}

class RemoteDataProvider(val dataProvider: IDataProvider = StandartDataProvider()): IDataProvider by dataProvider
{
    override fun getData(): Array<Int>
    {
        // Read data from some remote resource
        return arrayOf(1, 2, 3)   
    }
    fun createConnection(){}
}

class DataManager(val dataProvider: IDataProvider)
{
    // Some work with dataProvider
}

fun main()
{
    val dataProvider = FileDataProvider()
    val dataManager = DataManager(dataProvider) 
}