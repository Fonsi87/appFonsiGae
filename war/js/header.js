var urlNav;

$( document ).ready(function() {
	
	//Segun la URL, se sombrea la seccion de la barra de menu en la que me encuentro
	var pathname = window.location.pathname; // Returns path only
	if (pathname.toLowerCase().indexOf("inicio") >= 0){
		$('#menuHome').addClass('activemenu');
	}
	if (pathname.toLowerCase().indexOf("rating/") >= 0){
		$('#menu1').addClass('activemenu');
	}
	if (pathname.toLowerCase().indexOf("accionesgenerales/") >= 0){
		$('#menu2').addClass('activemenu');
	}
	if (pathname.toLowerCase().indexOf("consumosrda/") >= 0){
		$('#menu3').addClass('activemenu');
	}
	
});

function goToUrl(url){
	
		cargarModalEspera();
		document.location = url;
}

function cargarModalEspera(){
	
	$("#dialogEspere").dialog({
		resizable : false,
		draggable: false,
		position: {
            my: "center",
            at: "center",
            of: $("body"),
            within: $("body")
        },
		height : 200,
		modal : true,		
		open: function(event, ui) {
			$(".ui-dialog-titlebar-close").hide();
			$(".ui-dialog-titlebar").hide();
			$(".ui-dialog-title").hide();
			}
        });
	    
	return true;
}

function cerrarModalEspera(){
	
	$("#dialogEspere").dialog('close');
	$(".ui-dialog-titlebar-close").show();
	$(".ui-dialog-titlebar").show();
	$(".ui-dialog-title").show();
	
}