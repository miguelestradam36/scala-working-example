//> using dep "com.softwaremill.sttp.client4::core:4.0.0-M22"
//> using dep com.softwaremill.sttp.client4::core:4.0.0-M22

import scala.io.Source;
import scala.util.{Try, Success, Failure};
import java.io.{File, PrintWriter};
import sttp.client4.quick.*
import sttp.client4.Response

object Main
{
    def main(args: Array[String]): Unit = {
      val response: Response[String] = quickRequest.get(uri"https://httpbin.org/get").send()
      if (response.code.toString == "200"){
        val file = new File("data.json");
        val writer = new PrintWriter(file);
        // Will develop this part later
        // writer.write(response.headers);
        // println("Request header saved into JSON file...");
        writer.write(response.body);
        println("Request body saved into JSON file...");
        writer.close();
        println("Saved the data on the data folder...");
      } else {
        println("There was an error during the request")
      }
    }
}