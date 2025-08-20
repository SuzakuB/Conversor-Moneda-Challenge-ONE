# **Conversor de Moneda - Challenge ONE**
Este es un conversor de moneda de escritorio desarrollado en Java como parte del Challenge ONE de Alura Latam. La aplicación permite a los usuarios convertir valores entre diferentes divisas, obteniendo las tasas de cambio en tiempo real a través de una API externa.

## ✨ Características
Conversión Universal: Convierte entre múltiples divisas, incluyendo USD, MXN, KRW, JPY, CNY, ARS, BRL y COP.

Menú Dinámico: La aplicación presenta un menú interactivo en la consola para que el usuario elija la moneda de origen y de destino.

Tasas de Cambio en Tiempo Real: Utiliza la ExchangeRate-API para obtener datos de conversión actualizados.

Manejo de Errores: La aplicación está preparada para manejar posibles errores de conexión o de entrada de datos por parte del usuario.

## 🛠️ Tecnologías Utilizadas
Java: El lenguaje de programación principal. Se utilizó la versión 11 o superior. 


Java HttpClient: Para realizar las solicitudes HTTP a la API de tasas de cambio. 


Gson: Biblioteca de Google para analizar (parsear) la respuesta en formato JSON de la API. 


## 🚀 Instalación y Configuración
Para ejecutar este proyecto en tu máquina local, sigue estos pasos:

Clona el repositorio:

```
Bash
git clone https://github.com/SuzakuB/Conversor-de-Moneda.git
```
Abre el proyecto en tu IDE de preferencia (se recomienda IntelliJ IDEA).

Obtén tu API Key:

Crea una cuenta gratuita en 

ExchangeRate-API para generar tu clave de API personal. 

Configura tu API Key:

Navega al archivo Conversor.java.

Busca la línea String apiKey = "TU_API_KEY_AQUI"; y reemplaza "TU_API_KEY_AQUI" con tu clave personal.

Ejecuta la aplicación: Corre el método main en la clase Conversor.java.

## ▶️ Ejemplo de Uso
Una vez que la aplicación se está ejecutando, verás un menú en la consola. Sigue las instrucciones para realizar una conversión:

***************************************************
Sea bienvenido/a al Conversor de Moneda Universal

Elija la moneda de ORIGEN:
1) USD
2) MXN
3) KRW
4) JPY
5) CNY
6) ARS
7) BRL
8) COP
Su opción (o 0 para salir): 2

Elija la moneda de DESTINO:
1) USD
2) MXN
3) KRW
...
Su opción (o 0 para salir): 1

Ingrese el valor que desea convertir de MXN a USD: 500

El valor de 500.00 [MXN] corresponde al valor final de =>>> 29.45 [USD]
## Este proyecto fue desarrollado como parte del programa ONE (Oracle Next Education) en colaboración con Alura Latam.
