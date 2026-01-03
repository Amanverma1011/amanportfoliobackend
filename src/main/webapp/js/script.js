/* =================================================
   OLD-SCHOOL VANILLA JAVASCRIPT
   Backend-compatible version
================================================= */

document.addEventListener("DOMContentLoaded", function () {

  /* ---------- SMOOTH SCROLL FOR NAV LINKS ---------- */
  var navLinks = document.querySelectorAll("nav a");

  navLinks.forEach(function (link) {
    link.addEventListener("click", function (e) {
      var targetId = this.getAttribute("href");

      if (targetId && targetId.startsWith("#")) {
        var targetSection = document.querySelector(targetId);
        if (targetSection) {
          e.preventDefault();
          targetSection.scrollIntoView({
            behavior: "smooth"
          });
        }
      }
    });
  });

  /* ---------- ACTIVE NAV LINK ON SCROLL ---------- */
  var sections = document.querySelectorAll("section");

  window.addEventListener("scroll", function () {
    var scrollPos = window.scrollY + 150;

    sections.forEach(function (section) {
      if (
        section.offsetTop <= scrollPos &&
        section.offsetTop + section.offsetHeight > scrollPos
      ) {
        var id = section.getAttribute("id");

        navLinks.forEach(function (link) {
          link.classList.remove("active");
          if (link.getAttribute("href") === "#" + id) {
            link.classList.add("active");
          }
        });
      }
    });
  });

  /* ---------- CONTACT FORM (BACKEND HANDLED) ---------- */
  var form = document.querySelector("form");
  if (!form) return;

  form.addEventListener("submit", function () {
    // ✅ DO NOT preventDefault
    // Backend servlet will handle submission
  });

  /* ---------- SHOW SUCCESS / ERROR MESSAGE ---------- */
  var params = new URLSearchParams(window.location.search);
  var status = params.get("status");

  if (status === "success") {
    alert("Message sent successfully! ✅");
  } else if (status === "error") {
    alert("Something went wrong. Please try again ❌");
  }

  /* ---------- SMALL UX POLISH ---------- */
  var links = document.querySelectorAll("a");

  links.forEach(function (link) {
    link.addEventListener("mouseenter", function () {
      this.style.opacity = "0.8";
    });

    link.addEventListener("mouseleave", function () {
      this.style.opacity = "1";
    });
  });

});
