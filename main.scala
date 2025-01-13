//> using dep "com.softwaremill.sttp.client4::core:4.0.0-M22"
//> using toolkit latest

import scala.io.Source;
import scala.util.{Try, Success, Failure};
import java.io.{File, PrintWriter};
import sttp.client4.quick.*;
import sttp.client4.Response;
//import play.api.libs.json.Json;

object Main
{
    def main(args: Array[String]): Unit = {
      val response: Response[String] = quickRequest.get(uri"https://httpbin.org/get").send()
      if (response.code.toString == "200"){
        val file = new File("data.json");
        val writer = new PrintWriter(file);
        var data = "";
        for (elem <- response.headers) {
          val res = elem.toString.split(":");
          val a = res.head.toString;
          val b = res.last.toString;
          //val parsed = JSON.parseFull(elem.toString)
          var element = s"\n{\"${a}\":\"${b}\"},";
          //writer.write(parsed);
          data += element;
        }
        data += response.body;
        writer.write(data);
        println("Request saved into JSON file...");
        writer.close();
      } else {
        println("There was an error during the request")
      }
    }
}