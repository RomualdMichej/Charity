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


  var cus = document.querySelector('body > section');
  // console.log(cus);
  var t  = cus.lastElementChild;
  // console.log(t);
  var v = t.lastElementChild;
  // console.log(v);
  var re = v.lastElementChild;
  // console.log(re)

  var ruf = re.children;
  // console.log(ruf[1]);

  var to = ruf[1].firstElementChild.lastElementChild.firstElementChild.querySelector('.summary--text').innerHTML;
  // console.log(to);

  var button = document.querySelector('#gul');
  var number = document.querySelector('#number');
  var street = document.querySelector('#streetInput');
  var city = document.querySelector('#cityInput');
  var zip = document.querySelector('#zipCodeInput');
  var phone = document.querySelector('#phoneInput');
  var date = document.querySelector('#dataInput');
  var hour = document.querySelector('#hourInput');
  var text = document.querySelector('#textInput');
  var button1 = document.querySelector('#button1');
  var button2 = document.querySelector('#button2');
  var category = document.querySelectorAll('.category');
  var institution = document.querySelectorAll('.institution');
  var categoryId = '';
  var categoryName = '';
  var institutionId = '';
  var institutionName = '';

  button1.addEventListener("click", function () {
    for (var i = 0; i < category.length; i++) {
      // console.log(categoryId[i]);
      input = category[i];
      if(category[i].checked){
        categoryId += category[i].value;
      }
    }
  });

  button2.addEventListener("click", function () {
    for (var i = 0; i < institution.length; i++) {
      // console.log(institution[i]);
      input = institution[i];
      if(institution[i].checked){
        institutionId += institution[i].value;
      }
    }
  });


  button.addEventListener("click", function () {
    console.log('a. ' + institutionId);
    console.log('b. ' + categoryId);
    if(categoryId == 1){
      categoryName = ' ubrań, które nadają się do ponownego użycia.';
    }else if(categoryId == 2) {
      categoryName = ' ubrań, do wyrzucenia.';
    }else if(categoryId == 3){
      categoryName = ' zabawek.';
    }else if(categoryId == 4) {
      categoryName = ' książek.';
    }else if(categoryId == 6) {
      categoryName = ' piwerka.';
    }else if(categoryId == 8) {
      categoryName = ' chomikowych tabsów.';
    }else {
      categoryName = ' różnych rzeczy.';
    }

    if(institutionId == 1){
      institutionName = 'Dbam o Zdrowie';
    }else if(institutionId == 2) {
      institutionName = 'A kogo';
    }else if(institutionId == 3){
      institutionName = ' Dla dzieci';
    }else if(institutionId == 4) {
      institutionName = 'Bez domu';
    }else if(institutionId == 6) {
      institutionName = 'Szalony chomik';
    }else if(institutionId == 7) {
      institutionName = 'Browarek dla Janusza';
    }

    ruf[1].firstElementChild.lastElementChild.lastElementChild.querySelector('.summary--text').innerHTML = 'Dla fundacji ' + ' "' + institutionName + '".';

    // button.addEventListener("click", function () {
    var w1 = ' worek';
    var w2 = ' worki';
    var w3 = ' worków';
    if (number.value == 1) {
      ruf[1].firstElementChild.lastElementChild.firstElementChild.querySelector('.summary--text').innerHTML = number.value + w1 + ' ' + categoryName;
    }else if(number.value == 2 || number.value == 3 || number.value == 4 ){
      ruf[1].firstElementChild.lastElementChild.firstElementChild.querySelector('.summary--text').innerHTML = number.value + w2 + ' ' + categoryName;
    }else {
      ruf[1].firstElementChild.lastElementChild.firstElementChild.querySelector('.summary--text').innerHTML = number.value + w3 + ' ' + categoryName;
    }
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
