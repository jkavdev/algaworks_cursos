$(function() {
	console.log('Página carregada');

	var settings = {
		type : 'json',
		filelimit : 1,
		allow : '*.(jpg|jpeg|png)',
		action: '/fotos/',
		complete: function(resposta){
			console.log('Resposta ', resposta);
		}
	};

	UIkit.uploadSelect($('#upload-select'), settings);
	UIkit.uploadDrop($('#upload-frop'), settings);
});