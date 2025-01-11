//> using toolkit latest
//> using dep "com.softwaremill.sttp.client4::core:4.0.0-M22"
object APIRequest 
{
    def main(args: Array[String]) = {
      import sttp.client4.quick.*
      import sttp.client4.Response

      val response: Response[String] = quickRequest
        .get(uri"https://httpbin.org/get")
        .send()

      println(response.code)
      // prints: 200

      println(response.body)
      // prints some JSON string

      println(response.headers)
      // prints: Vector
    }
}