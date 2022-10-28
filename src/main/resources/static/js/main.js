function getHome(){
    const url = "http://localhost:8889/api/carfault/findAnswerByTrongSo/6";
    fetch(url)
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            data.forEach(d => {
                let select = document.getElementById('loiGapPhai');
                let option = document.createElement("option");
                option.text = d.cauTraLoi;
                option.value = d.cauTraLoi;
                select.add(option)
            })
        })
}
$(document).ready(getHome());

