# Introduction #

You will frequently want to implement inheritance in flows, where you have generic flow definition with the majority of your flow defined, but with specific behaviour defined in sub-classes of that flow.

# Details #

The `FlowImpl` class provides access to a map of the flow steps via the `getFlowStepsByName` method.  You may manipulate the contents of this map in your flow sub-classes.

An example of implementing this is provided in the `src/test/groovy/org/sgodden/viewflow/samples` folder.

Here is the super flow:
```

/**
 * A super flow which will be overridden by a sub-flow.
 * @author sgodden
 */
class SuperFlow extends FlowImpl {

    SuperFlow(){
        // you would have some named objects in real life
        //namedObjects = [
        //]

        initialStepName = "foo"
        
        steps = [
              [
                 name: "foo",
                 viewName: "fooView",
                 transitions: [ 
                     [on: "foo", to: "bar"],
                     [on: "toBeRemovedBySubFlow", to: "bar"]
                 ]
             ],
              [
                 name: "foo2",
                 viewName: "foo2View",
                 transitions: [ 
                     [on: "foo2", to: "bar"]
                 ]
             ],
             [
                 name: "bar",
                 viewName: "barView",
                 transitions: [
                     [on: "bar", to: "foo"],
                     [on: "bar2", to: "foo"]
                 ]
             ]
        ]
    }
}
```

And here is the sub-flow:
```
/**
 * An example of overriding view steps and transitions from a super-flow.
 * @author sgodden
 */
class SubFlow extends SuperFlow {

    SubFlow(){
        super();
        // insert a new step
        stepsByName['subFoo'] = [
            name: 'subFoo',
            viewName: 'subFooView'
        ];

        // remove a step
        stepsByName.remove('foo2');

        // remove a specific transition from a step
        stepsByName['foo'].transitionsByName.remove('toBeRemovedBySubFlow');

        // add a new transition to a step - the name is the same as the 'on' attribute
        stepsByName['foo'].transitionsByName['subFlowFoo'] = [
            [on: 'subFlowFoo', to: 'subFlowBar']
        ];
    }
}
```