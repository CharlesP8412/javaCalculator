
$(document).ready(function() {
  // console.log("DOC READY")
  const clickSubmit = function() {
    $('form button').on('click', event => {
      event.preventDefault();
      const leftOperand = $('#leftOperand').val()
      const rightOperand = $('#rightOperand').val()
      const operator = $("input[name='operator']:checked").val()
      $.ajax({
        method: 'POST',
        url: `http://localhost:8080/leftOperand=${leftOperand}rightOperand=${rightOperand}operation=${operator}`,
      })
        .then(res => {
          // const expression = res.data.Expression;
          // const result = res.data.Result;
          console.log("THEN...")
          const expression = "3+3"
          const result = "6"
          $('#expression').after(`<p>${expression}</p>`)
          $('#result').after(`<p>${result}</p>`)
        });
    })
  }
  clickSubmit();
});