package edu.eci.arep.parcial;

import static spark.Spark.*;
import com.google.gson.Gson;
import org.json.simple.JSONObject;

public class SparkWebServer {
    private static MathServices mathServices = new MathServices();

    /**
     * Metodo main del proyecto, el cual nos devuelve los diferentes resultados
     * dependiendo de la extension del get
     * @param args
     */
    public static void main(String[] args){
        JSONObject jsonObject = new JSONObject();
        port(getPort());

        /**
         * Metodo de tangente con respecto a "value"
         */
        get("/tan", (req, res) -> {
            Double value = Double.valueOf(req.queryParams("value"));
            Double tanValue = mathServices.tan(value);
            jsonObject.put("operation", "tan");
            jsonObject.put("input", value);
            jsonObject.put("output", tanValue);
            return jsonObject.toJSONString();
        });

        /**
         * Merodo de exp con respecto a "value"
         */
        get("/exp",(req, res) -> {
            Double value = Double.valueOf(req.queryParams("value"));
            Double expValue = mathServices.exp(value);
            jsonObject.put("operation", "exp");
            jsonObject.put("input", value);
            jsonObject.put("output", expValue);
            return jsonObject.toJSONString();
        });
    }

    /**
     * Obtiene el puerto
     * @return puerto tipo int
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
