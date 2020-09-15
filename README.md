# sintaks
Sintaks takes advantage of metamodels to generate fully operational tools for concrete syntaxes. 
It uses bidirectional mapping-models to support both model-to-text and text-to-model transformations (generators and parsers).

## Main features
Sintaks defines a mapping between metamodel concepts and a grammar.
Thanks to this mapping it offers:
- an editor (with code highlighting,...)
- prettyprinter (model-to-text serialization)
- parser (text-to-model deserialization)

The parser and prettyprinter are interpreted. This allows to have a good expressiveness of the mapping language.

