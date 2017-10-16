It works on 2.11.x
```
sbt:root> ++ 2.11.11 test
[info] Setting Scala version to 2.11.11 on 2 projects.
[info] Reapplying settings...
[info] Set current project to root (in build file:/tmp/macro-bug/)
[info] ExampleSpec:
[info] Example
[info] - should work with reference type
[info] - should also work with primitive type
[info] Run completed in 333 milliseconds.
[info] Total number of tests run: 2
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 2, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
```

and doesn't work on 2.12.x
```
sbt:root> ++ 2.12.3 test
[info] Setting Scala version to 2.12.3 on 2 projects.
[info] Reapplying settings...
[info] Set current project to root (in build file:/tmp/macro-bug/)
[info] ExampleSpec:
[info] Example
[info] - should work with reference type
[info] example.ExampleSpec *** ABORTED ***
[info]   java.lang.BootstrapMethodError: java.lang.NoSuchMethodError: example.ExampleSpec.$anonfun$new$4$adapted(Ljava/lang/Object;)Ljava/lang/Object;
[info]   at example.ExampleSpec$$anon$2.<init>(ExampleSpec.scala:11)
[info]   at example.ExampleSpec.$anonfun$new$3(ExampleSpec.scala:11)
[info]   at org.scalatest.OutcomeOf.outcomeOf(OutcomeOf.scala:85)
[info]   at org.scalatest.OutcomeOf.outcomeOf$(OutcomeOf.scala:83)
[info]   at org.scalatest.OutcomeOf$.outcomeOf(OutcomeOf.scala:104)
[info]   at org.scalatest.Transformer.apply(Transformer.scala:22)
[info]   at org.scalatest.Transformer.apply(Transformer.scala:20)
[info]   at org.scalatest.FlatSpecLike$$anon$1.apply(FlatSpecLike.scala:1682)
[info]   at org.scalatest.TestSuite.withFixture(TestSuite.scala:196)
[info]   at org.scalatest.TestSuite.withFixture$(TestSuite.scala:195)
[info]   ...
[info]   Cause: java.lang.NoSuchMethodError: example.ExampleSpec.$anonfun$new$4$adapted(Ljava/lang/Object;)Ljava/lang/Object;
[info]   at java.lang.invoke.MethodHandleNatives.resolve(Native Method)
[info]   at java.lang.invoke.MemberName$Factory.resolve(MemberName.java:962)
[info]   at java.lang.invoke.MemberName$Factory.resolveOrFail(MemberName.java:987)
[info]   at java.lang.invoke.MethodHandles$Lookup.resolveOrFail(MethodHandles.java:1390)
[info]   at java.lang.invoke.MethodHandles$Lookup.linkMethodHandleConstant(MethodHandles.java:1746)
[info]   at java.lang.invoke.MethodHandleNatives.linkMethodHandleConstant(MethodHandleNatives.java:477)
[info]   at example.ExampleSpec$$anon$2.<init>(ExampleSpec.scala:11)
[info]   at example.ExampleSpec.$anonfun$new$3(ExampleSpec.scala:11)
[info]   at org.scalatest.OutcomeOf.outcomeOf(OutcomeOf.scala:85)
[info]   at org.scalatest.OutcomeOf.outcomeOf$(OutcomeOf.scala:83)
[info]   ...
```