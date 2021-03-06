document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // TODO: get data from inputs and show them in summary
    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }



  //kod napisany przez RM

  //plik allUsers

  var enable = document.querySelectorAll('.enable');
  for (var i = 0; i < enable.length ; i++) {
    if(enable[i].innerHTML === '1') {
      enable[i].innerHTML = 'NIE';
      enable[i].className = 'user';
    }else if (enable[i].innerHTML === '0'){
      enable[i].innerHTML = 'TAK';
      enable[i].className = 'admin';

    }else {
      enable[i].innerHTML = 'ZABLOKOWANY';
      enable[i].className = 'ban';
    }
  }

  //plik form

  var button = document.querySelector('#button');
  var number = document.querySelector('#number');
  var street = document.querySelector('#streetInput');
  var city = document.querySelector('#cityInput');
  var zip = document.querySelector('#zipCodeInput');
  var phone = document.querySelector('#phoneInput');
  var date = document.querySelector('#dataInput');
  var hour = document.querySelector('#hourInput');
  var text = document.querySelector('#textInput');
  var category = document.querySelectorAll('.category');
  var categoryNames = document.querySelectorAll('.categoryName');
  var institution = document.querySelectorAll('.institution');
  var institutionNames = document.querySelectorAll('.institutionName');
  var institutionName = '';

  button.addEventListener("click", function () {

    var bags = document.querySelector('#bags');
    var w = '';
    if (number.value === '1') {
      w = ' worek zawierający:';
    }else if(number.value === '2' || number.value === '3' || number.value === '4' ){
      w = ' worki zawierające:';
    }else {
      w =  ' worków zawierających:';
    }
    bags.innerHTML = '<h4>' + number.value + w +'</h4>';
    var newUl = document.createElement("ul");
    bags.appendChild(newUl);
    for (var i = 0; i < category.length; i++) {
      if(category[i].checked){
        var newLi = document.createElement("li");
        newLi.innerHTML = '-' + categoryNames[i].innerHTML;
        newUl.appendChild(newLi);
      }
    }
    for (var i = 0; i < institution.length; i++) {
      if (institution[i].checked) {
        institutionName = institutionNames[i].innerHTML;
      }
    }
    document.querySelector('#inst').innerHTML = '<h4>' + 'Dla fundacji ' + institutionName + '.' + '</h4>';
    document.querySelector('#street').innerHTML = street.value;
    document.querySelector('#city').innerHTML = city.value;
    document.querySelector('#zip').innerHTML = zip.value;
    document.querySelector('#phone').innerHTML = phone.value;
    document.querySelector('#date').innerHTML = date.value;
    document.querySelector('#hour').innerHTML = hour.value;
    if(text.value) {
      document.querySelector('#text').innerHTML = text.value;
    }
  });
});
