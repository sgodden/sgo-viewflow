/* =================================================================
 # This library is free software; you can redistribute it and/or
 # modify it under the terms of the GNU Lesser General Public
 # License as published by the Free Software Foundation; either
 # version 2.1 of the License, or (at your option) any later version.
 #
 # This library is distributed in the hope that it will be useful,
 # but WITHOUT ANY WARRANTY; without even the implied warranty of
 # MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 # Lesser General Public License for more details.
 #
 # You should have received a copy of the GNU Lesser General Public
 # License along with this library; if not, write to the Free Software
 # Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 #
 # ================================================================= */
package org.sgodden.viewflow.samples

import org.sgodden.viewflow.config.FlowStep
import org.sgodden.viewflow.impl.FlowImpl

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
