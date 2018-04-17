var dataCount = 1;
var $div = $(".log");

var $tag = $(".select2-tag");
var $subTag = $(".select2-subTag");

$(document).ready(function () {
    $tag.on("select2:select", function (e) { changeSub("select2:select", e); });
    $subTag.on("select2:select", function (e) { changeSub("select2:select", e); });

    $tag.select2({
        /*ajax: {
            url: 'https://api.github.com/search/repositories',
            dataType: 'json'
            // Additional AJAX parameters go here; see the end of this chapter for the full code of this example
        },*/
        placeholder: "请选择一个标签",
        tags: true,
        data: data
    });


    $subTag.select2({
        placeholder: "请选择一个标签",
        tags: true,
        data: subDataInit
    });
});

// 子选择框根据父选择框选择的内容改动而改动
function changeSub (name, evt) {
    var selectedID = evt.params.data.id;
    for(i in subDatas){
        if(subDatas[i].id == selectedID){
            $subTag.val(null).trigger('change');

            $subTag.empty();
            $subTag.select2({
                tags: true,
                data: subDatas[i].sub
            });
            return;
        }
    }
}