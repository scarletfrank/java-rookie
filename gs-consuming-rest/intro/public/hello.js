$(document).ready(function() {
    $.ajax({
        url: " http://localhost:3000/greetings"
    }).then(function(datas) {
        // console.log(datas);
       var inx = Math.floor(Math.random() * 10);
       data = datas[inx]
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});