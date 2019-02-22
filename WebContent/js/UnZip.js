/**
 * 
 */
var $result = $("#result");
	
	//$("#file").on("change", function(evt) {
	$(document).ready(function(){
	$("#file").on("change" ,function(evt) {
	// 清空之前显示的条目
    $("#result").html("");
    // be sure to show the results
    
    $("#result_block").removeClass("hidden").addClass("show");

    // Closure to capture the file information.
    function handleFile(f) {
        // 压缩包名称
        
    	var $title = $("<h4>", {
            text : f.name
        });
    	
        var $fileContent = $("<h5>");
        $("#result").append($title);
        
        $("#result").append($fileContent);
        alert("123")
        var dateBefore = new Date();
        // 加载zip文件
        JSZip.loadAsync(f)                                   // 1) read the Blob
        .then(function(zip) {
            var dateAfter = new Date();
            $title.append($("<span>", {
                "class": "small",
                text:" (loaded in " + (dateAfter - dateBefore) + "ms)"
            }));

            zip.forEach(function (relativePath, zipEntry) {  // 2) print entries
                $fileContent.append($("<li>", {
                    text : zipEntry.name
                }));
            });
        }, function (e) {
        	$("#result").append($("<div>", {
                "class" : "alert alert-danger",
                text : "Error reading " + f.name + ": " + e.message
            }));
        });
    }

    var files = evt.target.files;
    for (var i = 0; i < files.length; i++) {
        handleFile(files[i]);
    }
});
});