const inputs = document.querySelectorAll(".input");


function addcl(){
	let parent = this.parentNode.parentNode;
	parent.classList.add("focus");
}

function remcl(){
	let parent = this.parentNode.parentNode;
	if(this.value == ""){
		parent.classList.remove("focus");
	}
}

//====================================================================
inputs.forEach(input => {
	input.addEventListener("focus", addcl);
	input.addEventListener("blur", remcl);
});
//=====================================================================
var assert = chai.assert

afterEach(function () {
    // destroy and remove all spinners
    $("input[type='number']").inputSpinner("destroy")
    $("input").remove()
})

describe('bootstrap-input-spinner', function () {
    it('Should display the spinner', function () {
        addInput()
        $("input[type='number']").inputSpinner()
    })
    // TODO more testing
})

function addInput() {
    var testContainer = document.getElementById("testContainer")
    var input = document.createElement("input")
    input.type = "number"
    testContainer.append(input)
}
//==========================================================================

//============================================================================


