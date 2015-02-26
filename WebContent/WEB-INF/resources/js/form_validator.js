  function checkDate(field)
  {
    var allowBlank = false;
    var minYear = 1902;
    var maxYear = (new Date()).getFullYear();

    var errorMsg = "";

    // regular expression to match required date format
    re = /^(\d{2})\.(\d{2})\.(\d{4})$/;

    if(field.value != '') {
      if(regs = field.value.match(re)) {
        if(regs[1] < 1 || regs[1] > 31) {
          errorMsg = "Invalid value for day: " + regs[1];
        } else if(regs[2] < 1 || regs[2] > 12) {
          errorMsg = "Invalid value for month: " + regs[2];
        } else if(regs[3] < minYear || regs[3] > maxYear) {
          errorMsg = "Invalid value for year: " + regs[3] + " - must be between " + minYear + " and " + maxYear;
        }
      } else {
        errorMsg = "Invalid date format: " + field.value;
      }
    } else if(!allowBlank) {
      errorMsg = "Empty date not allowed!";
    }

    if(errorMsg != "") {

      field.focus();
      return false;
    }

    return true;
  }

  function checkTime(field)
  {
    var allowBlank = false;
    var errorMsg = "";

    // regular expression to match required time format
    re = /^(\d{2}):(\d{2})$/;

    if(field.value != '') {
      if(regs = field.value.match(re)) {
        if(regs[1] > 23) {
          errorMsg = "Invalid value for hours: " + regs[1];
        }
        if(!errorMsg && regs[2] > 59) {
          errorMsg = "Invalid value for minutes: " + regs[2];
        }
      } else {
        errorMsg = "Invalid time format: " + field.value;
      }
    } else if(!allowBlank) {
      errorMsg = "Empty time not allowed!";
    }

    if(errorMsg != "") {

      field.focus();
      return false;
    }

    return true;
  }
