# Comecando com AngularJS

* definindo modulo principal da aplicaca `Angularjs`


        angular.module('Filmes', [])

* definindo um `controller` para uma pagina `html`


        angular.module('Filmes').controller('FilmesController', function ($scope) {}

* criando variaveis no `controller` e atribuindo ao `$scope` para acesso no `html`


        $scope.titulo = 'Filmes que já assisti';
        $scope.filmes = [
            {
                id: "321123",
                titulo: "Deadpool",
                ano: "2016",
                produtora: "Fox",
                sinopse: "Baseado no anti-herói não convencional da Marvel Comics, Deadpool conta a história da origem do ex-agente das Forças Especiais que se tornou o mercenário Wade Wilson. Depois de ser submetido a um desonesto experimento que o deixa com poderes de cura acelerada, Wade adota o alter ego de Deadpool. Armado com suas novas habilidades e um senso de humor negro e distorcido, Deadpool persegue o homem que quase destruiu sua vida.",
                cartaz: "http://www.mediaplus.com.br/clicfolha2016/uploads/imagem_arquivo/918856_cine1.png"
            }
        ];

* indicando ao `html` qual o modulo principal da aplicacao


        <html ng-app="Filmes">

* indicando o `controller` que sera responsavel por aquela porcao do `html`


        <div class="container" ng-controller="FilmesController">

* acessando os valores do `controller` no `html`


        <h1>{{ titulo }}</h1>

* realizando iteracao com o `ng-repeat`        
* `ng-repeat="filme in filmes"` temos uma variavel ``filme`` 
* e podemos acessar seus atributos `<h1>{{ filme.titulo }}</h1>`


        <div class="filme com-cartaz" ng-repeat="filme in filmes">
            <h1>{{ filme.titulo }}</h1>
            <button class="del" title="Excluir"></button>
            <img ng-src="{{ filme.cartaz }}" alt="Cartaz de {{ filme.titulo }}">
            <ul>
                <li><strong>Ano:</strong> {{ filme.ano }}</li>
                <li><strong>Produtora:</strong> {{ filme.produtora }}</li>
            </ul>
            <p>{{ filme.sinopse }}</p>
        </div>