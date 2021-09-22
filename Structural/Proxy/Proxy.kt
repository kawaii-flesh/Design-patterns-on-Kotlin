interface FileIO
{
    fun readFile(path: String)
    fun writeFile(path: String, text: String)
}

class SimpleFileIO: FileIO
{
    override fun readFile(path: String){}
    override fun writeFile(path: String, text: String){}
}

class ProxyFileIOWithLogger: FileIO
{
    val simpleFileIO = SimpleFileIO()
    override fun readFile(path: String)
    {        
        simpleFileIO.readFile(path)
        // Do logger stuff
    }
    override fun writeFile(path: String, text: String)
    {       
        simpleFileIO.writeFile(path, text) 
        // Do logger stuff
    }
}  

fun main()
{
    val proxy = ProxyFileIOWithLogger()
    proxy.readFile("file.txt") 
}