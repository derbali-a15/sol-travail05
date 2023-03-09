fetch('http://localhost:8080/travail04_war_exploded/api/banques')
    .then(resp => { return resp.json() })
    .then(data => {
        console.log(data)
    })