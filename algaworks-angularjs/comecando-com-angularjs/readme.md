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

* removendo um filme com `ng-click`        


        <button class="del" title="Excluir" ng-click="removerFilme(filme.id)"></button>

        $scope.removerFilme = function (id) {
            angular.forEach($scope.filmes, (filme, i) => {
                if (filme.id == id) {
                    $scope.filmes.splice(i, 1);
                }
            });
        }        

* preenchendo os dados do filme com `ng-model`


        <div class="form-campo">
            <label for="titulo">Título</label>
            <input type="text" id="titulo" ng-model="novoFilme.titulo">
        </div>
        <div class="form-campo pequeno">
            <label for="ano">Ano de Lançamento</label>
            <input type="number" id="ano" ng-model="novoFilme.ano">
        </div>

* adicionando um filme com no `submit` do formulario com `ng-submit`
* ao realizar o `submit` chama funcao no `controler`, `ng-submit="adicionarFilme()"`


        <form class="form-filmes" ng-submit="adicionarFilme()">
            <footer>
                <button type="reset">Limpar</button>
                <button type="submit">Salvar</button>
            </footer>
        </form>









