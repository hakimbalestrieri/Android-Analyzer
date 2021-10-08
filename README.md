#   : i p h o n e : S Y M   -   L a b o   1   -   I n t r o d u c t i o n   �   A n d r o i d  
  
 : b u s t _ i n _ s i l h o u e t t e :   * * A u t e u r s   : * *   ` A l e x i s   A l l e m a n n `   ,     ` H a k i m   B a l e s t r i e r i `   e t   ` C h r i s t i a n   G o m e s `  
  
 : p a g e _ f a c i n g _ u p :   * * E n   b r e f   : * *   C e   r e p o s i t o r y   c o n t i e n t   l a   r � a l i s a t i o n   d u   l a b o r a t o i r e   n o m m �   " I n t r o d u c t i o n   A n d r o i d "   d e   l ' [ H E I G - V D ] ( h t t p s : / / h e i g - v d . c h / ) .   C e   t r a v a i l   e s t   r � a l i s �   d u r a n t   l e   c o u r s   d e   S Y M .  
  
 : d a r t :   * * O b j e c t i f s   : * *   C e   l a b o r a t o i r e   e s t   c o n s t i t u �   d e   p l u s i e u r s   m a n i p u l a t i o n s   d e s t i n � e s   �   i m p l � m e n t e r   u n e   a p p l i c a t i o n   � l � m e n t a i r e   s u r   u n   � m u l a t e u r   e t / o u   s u r   u n   s m a r t p h o n e   A n d r o i d   d a n s   l e   b u t   d e   s e   f a m i l i a r i s e r   a v e c   l  e n v i r o n n e m e n t   ( I D E   e t   S D K )   d e   d � v e l o p p e m e n t   A n d r o i d .  
  
 # #   : t h i n k i n g :   P r e m i � r e s   c o n s t a t a t i o n s  
  
 # # #   L a n g u e   d e   l ' i n t e r f a c e  
  
 A f i n   d ' o b t e n i r   u n e   a p p l i c a t i o n   m u l t i - l a n g u e s ,   i l   f a u t   a v o i r   d e s   p a c k a g e s   d i f f � r e n t s   ` v a l u e s - x x `   ( x x   r e m p l a c �   p a r   l e   r a c c o u r c i   d e   l a   l a n g u e   ;   e x e m p l e   f r   p o u r   l e   f r a n � a i s )   q u i   c o n t i e n d r a   u n   f i c h i e r   ` s t r i n g s . x m l `   l a   l a n g u e .    
  
 E n   f o n c t i o n   d e   l a   l a n g u e   d u   s y s t � m e   d u   m o b i l e ,   l e   b o n   f i c h i e r   s t r i n g   e s t   u t i l i s �   a u t o m a t i q u e m e n t   p a r   l e   m o b i l e .   C ' e s t   d o n c   l e   p r i n c i p a l   i n t � r � t   d e   r e g r o u p e r   l e s   c h a � n e s   d e   c a r a c t � r e s   d a n s   d e s   f i c h i e r s   X M L   i n d � p e n d a n t s   e n   p l u s   d e   n e   p a s   a v o i r   �   d u p l i q u e r   l e s   l a y o u t s   p o u r   c h a q u e   l a n g u e .  
  
 L o r s q u ' u n e   t r a d u c t i o n   e s t   m a n q u a n t e   d a n s   u n e   l a n g u e ,   l a   v e r s i o n   d a n s   l a   l a n g u e   p a r   d � f a u t   e s t   u t i l i s � e   ( v i a   l e   f i c h i e r   ` s t r i n g s . x m l `   ) .   S i   u n   l i e n   m a n q u e   d a n s   l e   d o s s i e r   d e   l a   l a n g u e   p a r   d � f a u t ,   i l   y   a   u n e   e r r e u r   �   l a   c o m p i l a t i o n   ( l o r s   d u   m a p p i n g   d e s   r e s s o u r c e s   a v e c   l e s   s t r i n g s ) .  
  
 >   N o u s   a v o n s   u t i l i s �   l ' o u t i l   " T r a n s l a t i o n   E d i t o r "   d e   A n d r o i d   S t u d i o   p o u r   f a c i l e m e n t   g � r e r   l e s   l a n g u e s  
  
 # # #   C h a m p s   t e x t u e l s   d e   s a i s i e  
  
 A f i n   d ' e n l e v e r   l e s   s u g g e s t i o n s   d ' u n   c h a m p ,   l e   t y p e   ` t e x t N o S u g g e s t i o n s `   p e u t   � t r e   u t i l i s � .   P o u r   c e c i ,   i l   f a u t   a j o u t e r   l ' a t t r i b u t   s u i v a n t   �   l a   b a l i s e   X M L   d u   c h a m p   :    
  
 ` ` ` x m l  
 a n d r o i d : i n p u t T y p e = " t e x t N o S u g g e s t i o n s "  
 ` ` `  
  
 D a n s   n o t r e   c a s ,   n o u s   s o m m e s   a l l � s   p l u s   l o i n   q u e   d e   s u p p r i m e r   l e s   s u g g e s t i o n s   e n   u t i l i s a n t   l e   t y p e   d e   c h a m p   ` t e x t E m a i l A d d r e s s `   q u i   f a c i l i t e   l a   s a i s i e   d ' u n   e m a i l   a v e c   u n   c l a v i e r   a d a p t � .  
  
 P o u r   l e   m o t   d e   p a s s e ,   n o u s   a v o n s   u t i l i s �   l e   t y p e   ` t e x t P a s s w o r d `     ( t o u j o u r s   s u r   l a   p r o p r i � t �   ` a n d r o i d : i n p u t T y p e ` .  
  
 >   T a n t   l e s   t y p e s   ` t e x t E m a i l A d d r e s s ` e t   ` t e x t P a s s w o r d `   d � s a c t i v e n t   l e s   s u g g e s t i o n s  
  
 # # #   M o d e   p a y s a g e  
  
 P o u r   l e   m o d e   p a y s a g e ,   n o u s   a v o n s   c r � �   u n   n o u v e a u   l a y o u t .   L e s   l a y o u t s   e n   p a y s a g e s   s o n t   c r � � s   d a n s   l e   d o s s i e r   d e s   r e s s o u r c e s   d a n s   u n   d o s s i e r   ` l a y o u t - l a n d `   c o n t r a i r e m e n t   a u x   l a y o u t s   e n   p o r t r a i t   q u i   s e   t r o u v e n t   d a n s   u n   d o s s i e r   ` l a y o u t ` .  
  
 P o u r   f a i r e   d e u x   c o l o n n e s   d a n s   n o t r e   a p p l i c a t i o n   ( u n e   a v e c   l ' i m a g e   e t   u n e   a v e c   l e s   i n p u t s ) ,   n o u s   a v o n s   u t i l i s �   l e   c o m p o s a n t   ` L i n e a r L a y o u t `   q u i   p e r m e t   d e   d i s t r i b u e r   d e s   b l o c s   h o r i z o n t a l e m e n t .   E n s u i t e ,   n o u s   a v o n s   r � u t i l i s �   l e   c o m p o s a n t   ` c o n s t r a i n t L a y o u t `   p o u r   f a c i l e m e n t   a l i g n e r   l e s   i n p u t s   e t   l ' i m a g e .  
  
 # #   : p a u s e _ b u t t o n :   G e s t i o n   d e s   � v � n e m e n t s   e t   m i s e   �   j o u r   d e   l ' i n t e r f a c e   u t i l i s a t e u r  
  
 # # #   V � r i f i c a t i o n   d u   f o r m a t   d e   l  e - m a i l  
  
 P o u r   t e s t e r   q u e   l ' e m a i l   e s t   v a l i d e   ( q u ' i l   c o n t i e n t   l e   c a r a c t � r e   ` @ ` ) ,   n o u s   a v o n s   r � c u p � r �   l a   v a l e u r   d u   c h a m p   d e   l ' e m a i l   v i a   l ' a c t i v i t �   ` M a i n A c t i v i t y ` .  
  
 P o u r   a f f i c h e r   u n   t o a s t   s i   l ' e m a i l   n ' e s t   p a s   v a l i d e ,   v o i c i   l e   c o d e   n � c e s s a i r e   :    
  
 ` ` ` k o t l i n  
 T o a s t . m a k e T e x t ( a p p l i c a t i o n C o n t e x t ,   g e t S t r i n g ( R . s t r i n g . m a i n _ i n v a l i d _ e m a i l ) ,   T o a s t . L E N G T H _ L O N G ) . s h o w ( )  
 ` ` `  
  
 >   I c i ,   o n   r � c u p � r e   l a   s t r i n g   a v e c   l e   m e s s a g e   d ' e r r e u r   d a n s   l a   b o n n e   l a n g u e   e t   o n   a f f i c h e   l e   t o a s t   d u r a n t   5   s e c o n d e s   ( T o a s t . L E N G T H _ L O N G ) .  
  
 # # #   V � r i f i c a t i o n   d u   c o u p l e   e - m a i l   /   m o t   d e   p a s s e  
  
 P o u r   t e s t e r   q u e   l e   c o u p l e   e m a i l   /   m o t   d e   p a s s e ,   n o u s   a v o n s   r � c u p � r �   l a   v a l e u r   d u   c h a m p   d e   l ' e m a i l   v i a   l ' a c t i v i t �   ` M a i n A c t i v i t y ` .  
  
 P o u r   a f f i c h e r   u n e   f e n � t r e   d e   d i a l o g u e ,   v o i c i   l e   c o d e   n � c e s s a i r e   :    
  
 ` ` ` k o t l i n  
 v a l   b u i l d e r   =   A l e r t D i a l o g . B u i l d e r ( t h i s )  
 b u i l d e r . s e t T i t l e ( g e t S t r i n g ( R . s t r i n g . m a i n _ i n v a l i d _ u s e r _ t i t l e ) )  
 b u i l d e r . s e t M e s s a g e ( g e t S t r i n g ( R . s t r i n g . m a i n _ i n v a l i d _ u s e r _ m e s s a g e ) )  
 b u i l d e r . s e t P o s i t i v e B u t t o n ( a n d r o i d . R . s t r i n g . o k )   {   _ ,   _   - >   }  
 b u i l d e r . s h o w ( )  
 ` ` `  
  
 >   I c i ,   o n   c r � e   u n   b u i l d e r   d e   t y p e   ` A l e r t D i a l o g ` .   O n   d � f i n i t   e n s u i t e   s e s   p a r a m � t r e s   ( t i t r e ,   m e s s a g e   e t   a c t i o n s )   p u i s   o n   l ' a f f i c h e .  
  
 # #   : a r r o w _ r i g h t :   P a s s a g e   �   u n e   a u t r e   a c t i v i t �  
  
 # # #   C r � a t i o n   e t   l a n c e m e n t   d e   l a   n o u v e l l e   a c t i v i t �  
  
 L ' a c t i v i t �   ` U s e r P r o f i l e A c t i v i t y `   a   � t �   c r � e   v i a   l e s   a s s i s t a n t s   g r a p h i q u e   d e   A n d r o i d   S t u d i o .   N o u s   a v o n s   c h o i s i   l e   m o d � l e   d ' a c t i v i t �   ` E m p t y A c t i v i t y `   q u i   d � f i n i t   u n   s i m p l e   l a y o u t   v i d e .  
  
 >   C e t t e   a c t i o n   g � n � r e   a u t o m a t i q u e m e n t   l a   c l a s s e   d e   l ' a c t i v i t � ,   s o n   l a y o u t   X M L   e t   l ' a j o u t e   a u   M a n i f e s t  
  
 P o u r   l a n c e r   l ' a c t i v i t � ,   v o i c i   l e   c o d e   n � c e s s a i r e   :  
  
 ` ` ` k o t l i n  
 v a l   i n t e n t   =   I n t e n t ( t h i s   ,   U s e r P r o f i l e A c t i v i t y : : c l a s s . j a v a )  
 s t a r t A c t i v i t y ( i n t e n t )  
 ` ` `  
  
 >   I l   f a u t   u t i l i s e r   u n   o b j e t   d e   l a   c l a s s e   I n t e n t  
  
 # # #   P a s s a g e   d e   p a r a m � t r e s   �   l a   n o u v e l l e   a c t i v i t �  
  
 V o i c i   c o m m e n t   a j o u t e r   d e s   p a r a m � t r e s   �   u n   o b j e t   d e   l a   c l a s s e   ` I n t e n t `   :  
  
 ` ` ` k o t l i n  
 / /   P l a c e r   c e t t e   c o n s t a n t e   e n   d e h o r s   d e   l a   c l a s s e   d e   l ' a c t i v i t �   o u   d a n s   l e   c o m p a n i o n   o b j e c t  
 c o n s t   v a l   U S E R _ E M A I L   =   " c h . h e i g v d . i i c t . s y m . l a b o 1 . U S E R _ E M A I L "  
  
 v a l   i n t e n t   =   I n t e n t ( t h i s   ,   U s e r P r o f i l e A c t i v i t y : : c l a s s . j a v a ) . a p p l y   {  
         p u t E x t r a ( U S E R _ E M A I L ,   e m a i l I n p u t )  
 }  
 ` ` `  
  
 I c i ,   n o u s   a v o n s   a j o u t �   l e   p a r a m � t r e   a v e c   l a   c l �   ` " c h . h e i g v d . i i c t . s y m . l a b o 1 . U S E R _ E M A I L " ` .  
  
 >   L a   d � f i n i t i o n   d ' u n e   c o n s t a n t e   h o r s   d e   l a   c l a s s e   p e r m e t   d e   f a c i l e m e n t   r � c u p � r e r   l a   c l �   d e p u i s   u n e   a u t r e   a c t i v i t �  
  
 P o u r   r � c u p � r e r   l e   p a r a m � t r e ,   i l   s u f f i t   d ' u t i l i s e r   l e   c o d e   s u i v a n t   :    
  
 ` ` ` k o t l i n  
 i n t e n t . g e t S t r i n g E x t r a ( M a i n A c t i v i t y . U S E R _ E M A I L L )  
 ` ` `  
  
 >   ` i n t e n t `   e s t   e n   f a i t   l ' a p p e l   �   l a   m � t h o d e   ` g e t I n t e n t ( ) `   d e   l a   s u p e r   c l a s s e   ` A c t i v i t y `  
  
 # # #   P e r m i s s i o n s   s i m p l e s  
  
 P o u r   a u t o r i s e r   u n e   a p p l i c a t i o n   A n d r o i d   �   a c c � d e r   �   i n t e r n e t   e t   s e s   r e s s o u r c e s ,   i l   f a u t   a j o u t e r   l a   b a l i s e   s u i v a n t e   d a n s   l e   f i c h i e r   ` A n d r o i d M a n i f e s t . x m l `   :  
  
 ` ` ` x m l  
 < u s e s - p e r m i s s i o n   a n d r o i d : n a m e = " a n d r o i d . p e r m i s s i o n . I N T E R N E T "   / >  
 ` ` `  
  
 # #   : l e f t w a r d s _ a r r o w _ w i t h _ h o o k :   N a v i g a t i o n   e n t r e   l e s   a c t i v i t � s  
  
 # # #   C r � a t i o n   e t   l a n c e m e n t   d e   l a   n o u v e l l e   a c t i v i t �  
  
 L ' a c t i v i t �   ` N e w A c c o u n t A c t i v i t y `   a   � t �   c r � e   v i a   l e s   a s s i s t a n t s   g r a p h i q u e   d e   A n d r o i d   S t u d i o .   N o u s   a v o n s   c h o i s i   l e   m o d � l e   d ' a c t i v i t �   ` E m p t y A c t i v i t y `   q u i   d � f i n i t   u n   s i m p l e   l a y o u t   v i d e .   E n s u i t e ,   n o u s   a v o n s   i m p o r t �   l e s   c o m p o s a n t s   e t   l e   c o d e   n � c e s s a i r e   d e p u i s   l ' a c t i v i t �   p r i n c i p a l e .  
  
 * * R � s u l t a t   d ' u n e   a c t i v i t �   -   m � c a n i s m e   d ' o r i g i n e   : * *  
  
 P o u r   u t i l i s e r   c e t t e   o p t i o n ,   i l   e s t   n � c e s s a i r e   d e   l a n c e r   l ' a c t i v i t �   v i a   l a   m � t h o d e   ` s t a r t A c t i v i t y F o r R e s u l t ( ) `   :  
  
 ` ` ` k o t l i n  
 s t a r t A c t i v i t y F o r R e s u l t ( n e w   I n t e n t ( I n t e n t . A C T I O N _ P I C K , n e w   U r i ( " c o n t e n t : / / c o n t a c t s " ) ) ,   0 ) ;  
 ` ` `  
  
 >   I c i   l e   1 e r   p a r a m � t r e   e s t   l ' i n t e n t   e t   l e   d e u x i � m e   p a r a m � t r e   e s t   u n   i n t   q u i   d � f i n i t   l e   c o d e   d e   l a   r e q u � t e .   C e   c o d e   s e r a   u t i l i s �   p o u r   r � c u p � r e r   l a   r � p o n s e  
  
 P o u r   r � c u p � r e r   l a   r � p o n s e ,   i l   f a u t   r e d � f i n i r   l a   m � t h o d e   ` o n A c t i v i t y R e s u l t ( ) `   d e   l a   c l a s s e   p a r e n t e   ` A c t i v i t y `   :  
  
 ` ` ` k o t l i n  
   p r o t e c t e d   v o i d   o n A c t i v i t y R e s u l t ( i n t   r e q u e s t C o d e ,   i n t   r e s u l t C o d e ,   I n t e n t   d a t a )   {  
           i f   ( r e q u e s t C o d e   = =   0 )   {  
                   i f   ( r e s u l t C o d e   = =   R E S U L T _ O K )   {  
                           / /   h a n d l e   r e s u l t  
                   }  
           }  
 }  
 ` ` `  
  
 >   E n   l i g n e   2 ,   o n   f a i t   m a t c h e   l e   c o d e   d e   l a   r e q u � t e  
  
 * * R � s u l t a t   d ' u n e   a c t i v i t �   -   l i b r a i r i e   A n d r o i d X   : * *  
  
 A v e c   A n d r o i d X ,   o n   p e u t   d � f i n i r   u n e   f o n c t i o n   d e   c a l l b a c k   q u i   t r a i t e   l e   r � s u l t a t   :  
  
 ` ` ` k o t l i n  
 v a l   s t a r t F o r R e s u l t   =   r e g i s t e r F o r A c t i v i t y R e s u l t ( A c t i v i t y R e s u l t C o n t r a c t s . S t a r t A c t i v i t y F o r R e s u l t ( ) )   {   r e s u l t :   A c t i v i t y R e s u l t   - >  
                 i f   ( r e s u l t . r e s u l t C o d e   = =   A c t i v i t y . R E S U L T _ O K )   {  
                         / /   h a n d l e   r e s u l t  
                 }  
         }  
 ` ` `  
  
 I l   s u f f i t   e n s u i t e   d e   l a n c e r   l ' a c t i v i t �   a v e c   :    
  
 ` ` ` k o t l i n  
 s t a r t F o r R e s u l t . l a u n c h ( I n t e n t ( t h i s   ,   N e w A c c o u n t A c t i v i t y : : c l a s s . j a v a ) )  
 ` ` `  
  
 * * C o m p a r a i s o n   d e s   m � t h o d e s   : * *  
  
 L ' a v a n t a g e   d e   l a   p r e m i � r e   m � t h o d e   e s t   s a   s i m p l i c i t � .   E n   e f f e t ,   e l l e   e s t   t r � s   r a p i d e   �   m e t t r e   e n   p l a c e   e t   �   c o m p r e n d r e .   C e p e n d a n t ,   s i   l ' o n   d o i t   g � r e r   u n   g r a n d   n o m b r e   d e   r � s u l t a t s   c e t t e   s o l u t i o n   n ' e s t   p a s   t r � s   m o d u l a b l e .   L e   n o m b r e   d e   " i f "   i m b r i q u � s   v o n t   a u g m e n t e r ,   l e   c o d e   s e r a   � t r o i t e m e n t   c o u p l �   e t   d o n c   p l u s   d i f f i c i l e   �   t e s t e r   a u s s i .  
  
 L a   d e u x i � m e   m � t h o d e   p r o p o s e   u n e   a b s t r a c t i o n   q u i   p e r m e t   d e   g � r e r   l a   m � t h o d e   ` o n A c t i v i t y R e s u l t ( ) `   d a n s   u n e   s t r u c t u r e   t r � s   p r o p r e   e t   r � u t i l i s a b l e .   E l l e   e s t   c e p e n d a n t   p l u s   c o m p l i q u � e   �   c o m p r e n d r e   e t   �   m e t t r e   e n   p l a c e .   A v e c   c e t t e   s o l u t i o n ,   i l   e s t   a u s s i   e n v i s a g e a b l e   d e   c r � e r   u n e   c l a s s e   d � d i � e   a u   t r a i t e m e n t   d u   r � s u l t a t   d ' u n e   a c t i v i t � .   C e t t e   c l a s s e   p e u t   a l o r s   � t r e   i n s t a n c i � e   d e p u i s   d i v e r s e s   a c t i v i t � s   q u i   s o u h a i t e n t   t r a i t e r   l e s   m � m e   r � s u l t a t s .  
  
 # # #   A f f i c h a g e   d  u n e   i m a g e  
  
 P o u r   a j o u t e r   u n e   i m a g e ,   n o u s   s o m m e s   p a s s � s   p a r   l ' a s s i s t a n t   d ' i m p o r t   d e   A n d r o i d   S t u d i o .   L e   d o s s i e r   q u i   c o n t i e n t   l e s   i m a g e s   s e   t r o u v e   d a n s   l e s   r e s s o u r c e s   e t   e s t   n o m m �   " d r a w a b l e "   :   ` / r e s / d r a w a b l e ` .  
  
 I l   e x i s t e   d e u x   f a � o n s   d e   d � f i n i r   e t   d ' i n s t a n c i e r   u n   ` D r a w a b l e `   e n   p l u s   d ' u t i l i s e r   l e s   c o n s t r u c t e u r s   d e   c l a s s e   :  
  
 -   u t i l i s e r   u n e   r e s s o u r c e   d ' i m a g e   ( u n   f i c h i e r   b i t m a p )   e n r e g i s t r � e   d a n s   v o t r e   p r o j e t  
 -   u t i l i s e r   u n e   r e s s o u r c e   X M L   q u i   d � f i n i t   l e s   p r o p r i � t � s   p o u v a n t   � t r e   d e s s i n � e s  
  
 L e s   i m a g e s   d e s   r e s s o u r c e s   d u   d o s s i e r   ` / r e s / d r a w a b l e `   p e u v e n t   � t r e   a u t o m a t i q u e m e n t   o p t i m i s � e s   a v e c   u n e   c o m p r e s s i o n   d ' i m a g e   s a n s   p e r t e   p e n d a n t   l e   p r o c e s s u s   d e   c o n s t r u c t i o n .  
  
 U n   f i c h i e r   g r a p h i q u e   b i t m a p   ( . p n g ,   . j p g   o u   . g i f )   c r � e   u n   ` B i t m a p D r a w a b l e ` .   L ' u n   d e s   i n c o n v � n i e n t s   a s s o c i � s   �   u n e   i m a g e   b i t m a p   e s t   q u ' e l l e   n ' a   p a s   t e n d a n c e   �   s e   r e d i m e n s i o n n e r   t r � s   b i e n .   S ' i l   p e u t   � t r e   f a c i l e   d e   r � d u i r e   u n e   i m a g e   s a n s   p e r t e   d e   c l a r t � ,   i l   n ' e s t   p a s   f a c i l e   d ' a g r a n d i r   l ' i m a g e   s a n s   q u e   l ' i m a g e   n e   d e v i e n n e   p i x e l i s � e .   U n   a u t r e   i n c o n v � n i e n t   a s s o c i �   �   u n   b i t m a p   e s t   l a   g r a n d e   t a i l l e   d u   f i c h i e r .  
  
 L e s   a v a n t a g e s   d e   l ' u t i l i s a t i o n   d e   g r a p h i q u e s   v e c t o r i e l s   s o n t   d ' a v o i r   u n e   p e t i t e   t a i l l e   d e   f i c h i e r   e t   l a   p o s s i b i l i t �   d e   r e d i m e n s i o n n e r   l ' i m a g e   �   n ' i m p o r t e   q u e l l e   t a i l l e   s a n s   p e r t e   d e   q u a l i t �  
  
 I l   n ' e s t   p a s   p o s s i b l e   d ' u t i l i s e r   d e s   i m a g e s   v e c t o r i e l l e s   p o u r   t o u s   l e s   t y p e s   d ' i m a g e s .   L e   f o r m a t   v e c t o r i e l   e s t   t r � s   a d a p t �   a u x   l o g o s   o u   a u x   i c o n e s .   C e p e n d a n t ,   u n e   p h o t o   c o m p o s � e   d e   p i x e l s   n e   p e u t   p a s   � t r e   v e c t o r i s � e .   E n   e f f e t ,   l e s   g r a p h i q u e s   v e c t o r i e l s   s o n t   c o n s t i t u � s   d ' o b j e t s ,   d e   l i g n e s ,   d e   c o u r b e s   e t   d e   t e x t e   t a n d i s   q u e   l e s   i m a g e s   s o n t   c o n s t i t u � e s   d ' u n e   c o l l e c t i o n   d e   p o i n t s   o u   d e   p i x e l s .  
  
 # # #   F a c t o r i s a t i o n   d u   c o d e  
  
 A f i n   d e   f a c t o r i s e r   l e   c o d e   r e d o n d a n t   d e s   a c t i v i t � s   ` M a i n A c t i v i t y `   e t   ` N e w A c c o u n t A c t i v i t y `   n o u s   a v o n s   c r � e r   u n e   s u p e r c l a s s e   a b s t r a i t e   n o m m � e   ` U s e r P a s s w o r d A c t i v i t y ` .  
  
 V o i c i   u n e   r e p r � s e n t a t i o n   U M L   s i m p l i f i � e   d e   n o t r e   i m p l � m e n t a t i o n   :    
  
 ! [ ] ( / d o c / U M L - F a c t o r i s a t i o n . p n g )  
  
 L e s   m � t h o d e s   ` s e t C o n t e n t V i e w ( ) `   e t   ` o n S u b m i t ( . . . ) `   d o i v e n t   � t r e   r e d � f i n i e s   d a n s   l e s   c l a s s e s   e n f a n t   d e   l a   c l a s s e   a b s t r a i t e   ` U s e r P a s s w o r d A c t i v i t y ` .  
  
 P o u r   f a c t o r i s e r   u n   l a y o u t ,   i l   e s t   p o s s i b l e   d e   c r � e r   d e s   l a y o u t s   r � - u t i l i s a b l e s   e n   c r � a n t   d e s   f i c h i e r s   x m l .   E n s u i t e ,   i l   e s t   p o s s i b l e   d e   l e s   i n c l u r e s   e n   u t i l i s a n t   l a   b a l i s e   ` < i n c l u d e > `     :  
  
 ` ` ` x m l  
 < i n c l u d e   l a y o u t = " @ l a y o u t / t i t l e b a r " / >  
 ` ` `  
  
 >   L a   b a l i s e   ` < m e r g e   / > `   p e r m e t   d ' � l i m i n e r   l e s   g r o u p e s   d e   v u e s   r e d o n d a n t e s   d a n s   l a   h i � r a r c h i e   d e   v u e s   l o r s   d e   l ' i n c l u s i o n   d ' u n e   m i s e   e n   p a g e   d a n s   u n e   a u t r e .  
  
 # # #   C y c l e   d e   v i e  
  
 P o u r   r � a l i s e r   d e s   l o g s   s a n s   d u p l i c a t i o n s   d e   c o d e ,   n o u s   a v o n s   c r � �   u n e   c l a s s e   a b s t r a i t e   ` L o g s A c t i v i t y `   q u i   � t e n d   ` A p p C o m p a t A c t i v i t y ` .   L ' e n s e m b l e   d e   n o s   c l a s s e s   d e v a n t   a v o i r   d e s   l o g s   d u   c y c l e   d e   v i e   i m p l � m e n t e n t   c e t t e   s u p e r   c l a s s e   a b s t r a i t e .  
  
 L a   m � t h o d e   ` o n C r e a t e `   e s t   l a n c � e   l o r s q u ' u n e   a c t i v i t �   d � m a r r e   s u i v i   d e   ` o n S t a r t `   e t   d e   ` o n P o s t C r e a t e ` .   L o r s   d ' u n   c h a n g e m e n t   d ' a c t i v i t � ,   l ' a n c i e n n e   a c t i v i t �   p a s s e   p a r   l a   m � t h o d e   ` o n S t o p ` .   L o r s q u e   l ' o n   r e v i e n t   s u r   u n e   a c t i v i t � ,   l e s   m � t h o d e s   ` o n R e s u m e `   e t   ` o n P o s t R e s u m e `   s o n t   a p p e l � e s .   ` o n P a u s e `   e s t   a p p e l � e   l o r s q u e   l e   c o n t e n u   r e s t e   a f f i c h �   s u r   l ' a c t i v i t �   m a i s   q u e   c e l l e - c i   n ' e s t   p l u s   a c t i v e .   F i n a l e m e n t   ` o n D e s t r o y `   e s t   a p p e l � e   l o r s q u e   l ' o n   q u i t t e   u n e   a c t i v i t � .  
  
 V o i c i   u n   s c h � m a   q u i   p r � s e n t e   l e s   e n c h a � n e m e n t s   :    
  
 ! [ ] ( / d o c / A n d r o i d - A c t i v i t y - L i f e c y c l e . p n g )  
  
 