JSF: 1. Simple facelets

You start with basic project setup. You have Bean class, index.xhtml facelet, faces-config.xml.

Your task is to implement form that will allow user to type some text into text field.
When user clicks "Echo" button he should be presented with text "Echo: ..." where 3 dots represent user's input.

Create form with text input (id=txt) and bind it to bean's "text" attribute.
Create form with single button (id=send) and bind it to bean's "echo" method.
Create output text (id="response") that will show bean's "response" attribute. This control should not be present in
page's markup if value of "response" attribute is null.

Test your code.

What will happen if you do not wrap input and button with h:form?
What is the id of text input and output text components in rendered markup?
