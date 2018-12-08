angular.module('Filmes').controller('FilmesController', function ($scope) {

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

});