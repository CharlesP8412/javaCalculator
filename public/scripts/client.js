
$(document).ready(function() {
  // console.log("DOC READY")
  const clearOldResults = function() {
    $('#expression').text("Expression:");
    $('#result').text("Result:");
  }

  const clickSubmit = function() {
    $('form button').on('click', event => {
      event.preventDefault();
      clearOldResults();
      const leftOperand = $('#leftOperand').val()
      const rightOperand = $('#rightOperand').val()
      const operator = $("input[name='operator']:checked").val()

      // const expression = leftOperand + operator + rightOperand
      const expression = "3+3"
      const result = "6"
      $('#expression').text(`Expression: ${expression}`);
      $('#result').text(`Result: ${result}`);

      $.ajax({
        method: 'POST',
        url: `http://localhost:8080/leftOperand=${leftOperand}rightOperand=${rightOperand}operation=${operator}`,
      })
        .then(res => {
          //Display results from Server
          //const expression = res.data.Expression;
          //const result = res.data.Result;
          //$('#expression').text(`Expression: ${expression}`);
          //$('#result').text(`Result: ${result}`)
        })
        .catch(e => console.log("ERROR:", e));
    })
  }
  clickSubmit();
});
