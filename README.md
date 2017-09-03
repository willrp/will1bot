# Will1bot 

Will1bot is a chatbot for TypeTalk™, built in Java, to help workers on daily activities.
It interfaces with TypeTalk API through Webhook.

It's main page can be accessed [here](http://will1bot.herokuapp.com/).

## Functionalities

* Greetings;
* Report weather conditions for workers at Fukuoka-shi, preparing to return home;
* Phrase translation from English to Portuguese, in order to help with Brazilian business partners.

## How to

* Create your bot with Webhook URL for your topic ([docs](https://developer.nulab-inc.com/docs/typetalk/#webhook))
* For the URL, use: http://will1bot.herokuapp.com/webhook/
* After the bot is added to a topic, send a message mentioning him, i. e., beginning with @botname+

One an get the code and deploy it elsewhere. The only part not included is the weather Webservice API key.

## Commands

* **Greetings:** "@botname+ hello", e. g., "@will1bot hello". Works with "hi" and "konnichiwa" as well;
* **Weather:** "@botname+ weather", e. g., "@will1bot weather";
* **Translate EN-PT:** "@botname+ translate phrase", e. g., "@will1bot translate I love sushi".

## Technical features

Tools used to build Will1bot:

 * **Java:** The programming language and platform;
 * **Jersey:** Framework that extends JAX-RS for building RESTful service and client development, for N-tier architectures;
 * **Moxy:** Manages object to JSON/XML mapping, default on Jersey. For managing IO JSON data;
 * **JSONParser:** To parse multidimensional JSON arrays, since Moxy has a [bug](https://bugs.eclipse.org/bugs/show_bug.cgi?id=389815) and does not work with this kind of data.

The following packages contain classes that allows Moxy to manage object to JSON mapping:

 * **jp.will.will1bot.controller.parser:** Parses incoming JSON, creating objects based on the received data;
 * **jp.will.will1bot.controller.marshalling:** Marshalls outgoing data, creating JSON based on objects data.

In order to emphasize decoupling and structural organization, so the application is kept simple, understandable by other developers and with good scalability, in order to easily accommodate other funcionalities, this application is organized in layers, following the MVCS design pattern:

 * Controller: Layer that manages the routes and controls incoming requests, as well as the replies. Often named as Resource. Package jp.will.will1bot.controller:
 
     * **WebhookController**: Manages incoming data from Typetalk webhook and the replies;

 * Service: Layer that manages the application business logic. Communicates with other service classes when other business logic context arises, create domain model objects for data input, e. g., a product data, or uses data classes in order to retrieve data from databases or other Webservices. dataPackage jp.will.will1bot.service:
 
     * **RequestService**: Manages request coming from controller layer and delegates the processing to the inner service layer classes, based on the input received;
     * **GreetingsService**: Manages the greetings functionality. Built to figure out how to properly work with Typetalk;
     * **TranslateService**: Manages the translation functionality logic, ordering data fetch from the respective data class and replying accordingly;
     * **WeatherService**: Manages weather report funcionality logic, ordering data fetch from the respective data class and replying accordingly. It receives a model class as a response from data class, and uses it's method for the reply.

 * Model: Domain model layer that represents entities present on the system. Often named as Domain. Package jp.will.will1bot.model:
 
     * **Weather**: Represents weather entity, with all information and inner logic.
     
 * Web: Layer that manages data fetching from other Webservices, on a multitier architecture. Since Will1bot does not have all data to reply incoming requests, it needs to fetch it from elsewhere. Often named as DAO when refering to database. Package jp.will.will1bot.web:
 
     * **TranslateWeb**: Fetches data from the translator Webservice;
     * **WeatherWeb**: Fetches data from the weather Webservice.

View layer is actually not used on Will1bot because Typetalk manages this part of the Web application.
Since a translated phrase does not represent a complex entity, a model class was not made for it.
To add other functionalities is very simple. One only needs to create the proper service and data/model classes, as well as the command processing at RequestService class.

## Authors

Engineered and coded by:
* **Will Roger Pereira** - https://github.com/willrp

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
