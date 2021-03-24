package edu.eci.arep.parcial;

import static spark.Spark.*;

public class SparkWebServer {
    private static MathServices mathServices = new MathServices();

    /**
     * Metodo main del proyecto, el cual nos devuelve los diferentes resultados
     * dependiendo de la extension del get
     * @param args
     */
    public static void main(String[] args){
        port(getPort());

        /**
         * Metodo de tangente con respecto a "value"
         */
        get("/tan", (req, res) -> {
            Double value = Double.valueOf(req.queryParams("value"));
            return(mathServices.tan(value));
        });

        /**
         * Merodo de exp con respecto a "value"
         */
        get("/exp",(req, res) -> {
            Double value = Double.valueOf(req.queryParams("value"));
            return(mathServices.exp(value));
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
