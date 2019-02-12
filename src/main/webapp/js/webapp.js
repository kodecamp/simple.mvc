
console.log('js loaded');
function init() {
  console.log("script initialized");
  const buttons = document.querySelectorAll('button');
  console.log(buttons);

  for (const button of buttons) {
    button.addEventListener('click', (event) => {
      event.preventDefault();
      const appForm = document.forms[0];
      console.dir(appForm);
      console.log("@before -> form.action : " + appForm.getAttribute("action"));
      appForm.action = appForm.getAttribute("action") + "/" + event.target.value + ".xhtml";
      console.log("@after -> form.action : " + appForm.getAttribute("action"));
      appForm.submit();
    });
  }
}



init();
