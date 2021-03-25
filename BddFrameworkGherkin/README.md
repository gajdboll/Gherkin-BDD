# V7 Cucumber &Maven 

To do that we need 2 plugins :]
-Maven Compiler plugin (allows to cleaan, run etc . project - we will find out all sets of all the new commands for that)
- Maven serefire plugin - which generate 2 version of reports - used in test phase to execute unit tests of application
	(*txt report , *.xml report) - => by default created at location ${basedir/target/selfire-reports}
	
	in the pom file we ad on top tags<build></build> inside <plugins></plugins>then inside <plugin></plugin> and inside the plugin we add those dependencies.
	Dependecy tags needs to be removed
	
	
-clean – usuwa folder target, czyli skompilowany kod
-validate – waliduje projekt i sprawdza obecność wszystkich potrzebnych informacji do kompilacji
-compile – kompiluje kod projektu
-test – kompiluje i uruchamia testy jednostkowe
-package – kompiluje i pakuje kod do zadanego formatu, na przykład *.jar, czyli tworzy tzw. paczkę dystrybucyjną
-verify – uruchamia „check” zdefiniowany w projekcie w celu sprawdzenia czy utworzona paczka dystrybucyjna jest poprawna
-install – instaluje paczkę dystrybucyjną do lokalnego repozytorium, tak aby inne projekty mogły z niego korzystać
-site – generuje dokumentację projektu
-deploy – kopiuje ostateczną paczkę projektu do zdalnego repozytorium

Poszczególne fazy mogą być od siebie zależne. Na przykład wywołanie komendy deploy będzie wymagać wcześniejszego utworzenia paczki dystrybucyjnej.
W ostatnim akapicie pojawiły nam się takie zwroty jak paczka dystrybucyjna, repozytorium. Należy je sobie wytłumaczyć.

Paczka dystrybucyjna to skompilowany i zbudowany kod w formie na przykład pliku *.jar, *.war lub innego w zależności od ustawień projektu. Większość projektów javowych typu open source jest w ten sposób dystrybuowana przez Internet.

Repozytorium zaś to nic innego jak zbiór plików dystrybucyjnych składających się z wielu artefaktów (plików) w różnych wersjach. Jednym z takich artefaktów jest na przykład Selenium czy TestNG, którego będziemy używać. Repozytoria można podzielić na:

Lokalne – przykładem takiego repozytorium jest nasz komputer, na którym mamy zainstalowanego Mavena. Jeśli na takim komputerze uruchomimy teraz kod źródłowy, którego projekt będzie projektem mavenowym z komendą „install”, to u nas na komputerze zostanie utworzona paczka tego projektu oraz zainstalowana do naszego lokalnego repozytorium.
Zdalne – są to repozytoria w Internecie, z reguły ogólnodostępne. Przykładem takiego repozytorium jest https://mvnrepository.com/. Innym przykładem może być repozytorium firmowe.
Jest to tylko wstęp do Mavena. Jeśli chcesz dowiedzieć się więcej zapoznaj się z oficjalną dokumentacją Mavena dostępną pod adresem: http://maven.apache.org/guides/