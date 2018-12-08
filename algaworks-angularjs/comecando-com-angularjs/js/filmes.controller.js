angular.module('Filmes').controller('FilmesController', function ($scope) {

    $scope.titulo = 'Filmes que já assisti';

    $scope.filmes = [
        {
            id: "4",
            titulo: "Deadpool",
            ano: "2016",
            produtora: "Fox",
            sinopse: "Baseado no anti-herói não convencional da Marvel Comics, Deadpool conta a história da origem do ex-agente das Forças Especiais que se tornou o mercenário Wade Wilson. Depois de ser submetido a um desonesto experimento que o deixa com poderes de cura acelerada, Wade adota o alter ego de Deadpool. Armado com suas novas habilidades e um senso de humor negro e distorcido, Deadpool persegue o homem que quase destruiu sua vida.",
            cartaz: "http://www.mediaplus.com.br/clicfolha2016/uploads/imagem_arquivo/918856_cine1.png"
        },
        {
            id: "3",
            titulo: "The Predator",
            ano: "2018",
            produtora: "Fox",
            sinopse: "When a young boy accidentally triggers the universe's most lethal hunters' return to Earth| only a ragtag crew of ex-soldiers and a disgruntled scientist can prevent the end of the human race.",
            cartaz: "https://dyncdn.me/mimages/329873/poster_opt.jpg"
        }
    ];

    $scope.novoFilme = {};

    $scope.removerFilme = function (id) {
        angular.forEach($scope.filmes, (filme, i) => {
            if (filme.id == id) {
                $scope.filmes.splice(i, 1);
            }
        });
    }

    $scope.adicionarFilme = function () {
        const filme = angular.copy($scope.novoFilme);
        filme.id = Date.now();
        $scope.filmes.push(filme);
        $scope.novoFilme = {};
    }

});