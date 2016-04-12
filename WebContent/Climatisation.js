$(function() {
	$("#sourceNb").blur(function(){	     
	    $.ajax({
	       url : 'NombreClimatisationsController',
	       type : 'GET',
	       dataType : 'text',
	       success : function(texte){
	           $("#nbId").html(texte); // On passe code_html à jQuery() qui va nous créer l'arbre DOM !
	       },
	    });
	});
});
